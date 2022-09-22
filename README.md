# Springboot-cloud-stream-kafka
Springboot, cloud stream and kafka

# To run the docker-compose file from its location(using terminal):
docker-compose -f docker-compose.yml up

# To get inside kafka container using container id(docker ps):
docker exec -it 5d3495099d8a /bin/sh

# To create topic
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic TOPIC.RAJESHKAWALI

# To list the topics
kafka-topics.sh --list --zookeeper zookeeper:2181

# Kafka producer
kafka-console-producer.sh --broker-list localhost:9092 --topic TOPIC.RAJESHKAWALI

# Kafka consumer from beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic TOPIC.RAJESHKAWALI --from-beginning