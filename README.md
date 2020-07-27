# MessageKafkaService

Simple spring-boot application which RestController can receive message as POST request on URL=http://localhost:8080/send_message
with parameters "from" and "to" (e.g. http://localhost:8080/send_message?from=Sveta&to=Kate) and message text in request body. 
Then Kafka producer serializes this message to JSON and send it to Kafka server. 
Kafka listner can consume this message and deserialize it from JSON.


