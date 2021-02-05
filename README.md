### application-aws.yml

```yaml
---
spring:
  profiles: dev
cloud:
  aws:
    sqs:
      queue:
        url: <Queue-url>
    region:
      static: <Queue-region>
    credentials:
      accessKey: <AWS-accesskey>
      secretKey: <AWS-secretkey>
      instance-profile: true
    stack:
      auto: false
```

### application-email.yml

```yaml
---
spring:
  profiles: dev
mail:
  google:
    sender: <send-email>
    password: <send-email-password>

```