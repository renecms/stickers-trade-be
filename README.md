## Environment Variables
```
POSTGRES_URL=jdbc:postgresql://localhost:5432/postgres
POSTGRES_PASSWORD=postgres
```

## Create docker image in gcloud
```
mvn compile jib:build  
```
## Create docker image in locally
```
mvn compile jib:dcokerBuild  
```

## Deploy to cloud run
```
gcloud run deploy stickers-trade-be --image gcr.io/stickers-364919/stickers-trade-be --platform managed --vpc-connector cloud-run-connector
```
