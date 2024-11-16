# Learn Microservices

## MQ convetions

| Exchange           | Type  | Routing Key            | Queue                  | 
|--------------------|-------|------------------------|------------------------|
| catalog_ms.product | topic | product.event.created  | queue.product_created  |
| catalog_ms.product | topic | product.event.modified | queue.product_modified |

