# StudentApp API

## Dependencies

* Java 8+ (Java 11 recommended)


## Building

```sh
mvn clean build
```

## Running

```sh
nohup mvn spring-boot:run &
```

## Test API

```sh
http://localhost:7080/health-check

```
##Swagger Documentation URL
```bash
http://localhost:7080/swagger-ui.html
```

## Command to generate current Date time
```bash
echo $(date +%Y%m%d)$(date +%H%M%S)
```




