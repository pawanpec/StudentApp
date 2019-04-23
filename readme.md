# StudentApp API

## Dependencies

* Java 8+ (Java 11 recommended)
* MySQL Server

## Configuration

Configure the `.env.local` file as follows:

```sh
cp .env.sample .env.local
vim .env.local

# optional (do this for running yarn commands manually in frontend):
source .env.local
```

If you want to launch tomcat from within your IDE, you will need to configure
and export the appropriate environment variables.

### Database

MySQL is required to run the API service. You'll need to initialize an
empty database:

```sql
create database student_app;
```

All tables and data will be loaded when you start the service.

## Building

```sh
make clean build
```

## Running

```sh
make spring
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




