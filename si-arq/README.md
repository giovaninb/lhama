# SI Architectural LIB #

## OBJETIVO ##

Trazer um padrão para o uso de ferramentas comuns entre os microservices desenvolvidos pelo time de SI. 

## FEATURES ##

Versão 1.0 (Jan/2019): 

*  Integração Kafka: Consumers e Producers dinâmicos ( Criação através de Beans )
*  JsonHelper ( Padrão Único para transformação de Json )
*  DateTimeHelper ( Padrão Único para gerenciamento de Datas )
*  Versionamento de API's
    *  Spring-Boot
    *  Camel
    *  Kafka Driver
    *  Lombok
	
## Tutoriais ##

### Criação de Consumer/Producer para Tópicos do Kafka ###

Criar uma aplicação no WEB Java + Maven em https://start.spring.io/

**OBS:** O campo **group** obrigatóriamente deve ser **com.zenvia.si**, devido ao contexto do Spring fazer a busca pelos beans neste pacote no si-arq ( ponto de melhoria futura )

Adicionar o projeto SI-ARQ ao pom do novo projeto:


```xml

		<dependency>
			<groupId>com.zenvia.si</groupId>
			<artifactId>si-arq</artifactId>
			<version>última versão</version>
		</dependency>

```


Dentro do pacote raiz do projeto (com.zenvia.si ou o mesmo da classe main do projeto) deve ser criada uma classe chamada KafkaBeans.java e deve seguir o seguinte padrão:


```java

		@Configuration
		public class KafkaBeans {


		}

```

Para a criação de um novo Consumer, deve ser criado um método que retorne um objeto do tipo Consumer ou Producer, que será descrito posteriormente.


```java

		@Configuration
		public class KafkaBeans {

			@Bean
			public Consumer customerConsumerBean() {
				return new CustomerConsumer();
			}

			@Bean
			public Consumer customerConsumerBean() {
				return new CustomerConsumer();
			}

			@Bean
			public Producer customerProducerBean() {
				return new CustomerProducer();
			}

		}

```


Cada método irá retornar o Bean que deve ser utilizado, seja para consumir quanto para produzir um evento. 
Abaixo está descrito como deve ser a classe responsável por consumir eventos do tópico. 
O método process irá receber o Stream no formato texto e o Metadata indica a sua origem e dados relacionados ao evento como um todo.


```java

		@Slf4j
		@Data
		public class CustomerConsumer implements Consumer{

			@Value("${kafka.consumer.customer.id}")
			private String id;

			@Value("${kafka.consumer.customer.topic}")
			private String topic;

			@Value("${kafka.consumer.customer.event}")
			private String event;

			public void process(Metadata metadata, String body) {
				log.info("-----------> Process --- Stream");
			}

		}

```

A classe para a criação de um Producer deve seguir o modelo abaixo e ter um método para cada tipo de evento criado ou action, centralizando todo o processo que 
envolve o envio do stream em um único local facilitando o uso de arquiteturas hexagonais.


```java

		@Data
		public class CustomerProducer implements Producer{

			@Autowired
			private KafkaService ks;

			@Value("${kafka.producer.customer.id}")
			private String id;

			@Value("${kafka.producer.customer.topic}")
			private String topic;

			@Value("${kafka.producer.customer.event}")
			private String event;

			public void sendNewCustomerEvent(NewCustomer newCustomer) {
				ks.send(newCustomer, id, "newcustomer", "new");
			}

			public void sendDeleteCustomerEvent(NewCustomer newCustomer) {
				ks.send(newCustomer, id, "deletecustomer", "delete");
			}

		}

```


Uma premissa para a criação, tando de um Consumer quanto Producer, é a criação das propriedades no arquivo .properties referentes aos ID's e dados do tópico.


```properties

		application.source=myappname

		kafka.consumer.customer.id=customerConsumerId
		kafka.consumer.customer.topic=CUSTOMER_SYSCORP
		kafka.consumer.customer.event=error
		kafka.consumer.customer.source=crm
	
```

O uso da classe producer deve seguir o exemplo abaixo, que demonstra uma classe controller de uma aplicação de exemplo:

```java

		@RestController
		@RequestMapping("/arq")
		public class SampleController {

			@Autowired
			private ApplicationContext context;

			@GetMapping
			public ResponseEntity<String> sendTestToKafka(){
				CustomerProducer customerProducer = context.getBean(CustomerProducer.class);

				NewCustomer newCustomer = NewCustomer
						.builder()
							.name("Isidoro de Sevilla")
							.age(300)
						.build();

				customerProducer.sendNewCustomerEvent(newCustomer);

				return new ResponseEntity<>("msg:ok", HttpStatus.OK);
			}

		}


```


Qualquer dúvida ou sugestão pode enviada para thafarel.camargo@zenvia.com :)



