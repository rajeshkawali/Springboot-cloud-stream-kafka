# Springboot-cloud-stream-kafka
Springboot, cloud stream and kafka

### To run the docker-compose file from its location(using terminal):
docker-compose -f docker-compose.yml up

### To get inside kafka container using container id(docker ps):
docker exec -it 5d3495099d8a /bin/sh

### To create topic
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic TOPIC.RAJESHKAWALI

### To list the topics
kafka-topics.sh --list --zookeeper zookeeper:2181

### Kafka producer
kafka-console-producer.sh --broker-list localhost:9092 --topic TOPIC.RAJESHKAWALI

### Kafka consumer from beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic TOPIC.RAJESHKAWALI --from-beginning




# Basic Kafka Interview Questions and Answers
### 1. What is Apache Kafka?
Answer:
Apache Kafka is a distributed event streaming platform capable of handling trillions of events a day. It's used to build real-time data pipelines and streaming applications. Kafka is fast, scalable, durable, and fault-tolerant.

### 2. What are the main components of Kafka?
Answer:
Producer – Sends records (data) to Kafka topics.
Consumer – Reads records from topics.
Broker – Kafka server that stores and serves data.
Topic – Logical channel to which data is sent.
Partition – Topic is split into partitions for scalability.
ZooKeeper (deprecated in newer versions) – Used for coordination and metadata management (now replaced by KRaft mode).

### 3. What is a Kafka Topic?
Answer:
A topic is a logical channel or category to which records are published. Consumers subscribe to topics to read messages.

### 4. What is a Kafka Partition?
Answer:
Each topic is divided into one or more partitions. Partitions allow Kafka to scale horizontally by distributing data across multiple brokers.

### 5. What is a Kafka Broker?
Answer:
A broker is a Kafka server that stores and serves messages for topics. A Kafka cluster is made up of multiple brokers.

### 6. How does Kafka ensure message durability?
Answer:
Messages are written to disk and replicated across brokers (based on replication factor). Even if a broker goes down, replicas ensure no data loss.

### 7. What is a Consumer Group?
Answer:
A group of consumers that work together to consume data from a topic. Each partition is consumed by only one consumer in the group, enabling parallel processing.

### 8. What is Kafka retention policy?
Answer:
Kafka retains messages for a configurable amount of time (e.g., 7 days) or size limit, regardless of whether they are consumed.

### 9. What is the role of Zookeeper in Kafka?
Answer:
(ZooKeeper is now optional in newer Kafka versions with KRaft mode)
ZooKeeper was used to manage metadata, leader election, and configuration synchronization between Kafka nodes.

### 10. How is ordering guaranteed in Kafka?
Answer:
Kafka guarantees ordering within a partition, not across partitions.

