
## Pre-requisites

* JDK 8+
* Docker

## Building

### Testing

`./gradlew test`

### Building (no tests)

`./gradlew assemble`

### Building (with tests)

`./gradlew build`

### Running in Docker

`./gradlew assemble docker dockerRun`

### Stopping Docker container

`./gradlew dockerStop`

### Deploying to AWS

`./gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=<your-subnet-id> -Pregion=<your-region>`

### Deleting AWS deployment

`./gradlew awsCfnDeleteStack awsCfnWaitStackComplete`

## Using API

* get all products - GET [/product](http://localhost:8080/product) to get a list of all the products
* get specific product - GET [/product/${id}](http://localhost:8080/product/1) to get a specific product
* add product - POST JSON to [/product](http://localhost:8080/ride) to create a new product 
 
