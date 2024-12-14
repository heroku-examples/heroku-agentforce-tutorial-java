
Creating Agentforce Custom Actions with Heroku - Java
=====================================================

> 💡 **Heroku Integration Pilot Only:**<br/> This branch is only intended for developers who have joined the Heroku Integration Pilot. if you have not please refer to the main branch of this repository for alternative instructions.

This tutorial explains how to deploy a Heroku application written in Java that can be used to build an Agentforce custom action, extending the capabilities of any Agentforce agent with the power of Heroku's fully managed, elastic compute services.

Deploying to Heroku
-------------------

You can deploy this application to your Heroku account using the button below or manually via the CLI.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

To proceed with a CLI deployment, install the [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli) and log in with your Heroku account (or [sign up](https://signup.heroku.com/)). Then, execute the following CLI commands:

```
git clone -b heroku-integration-pilot https://github.com/heroku-examples/heroku-agentforce-tutorial-java
cd heroku-agentforce-tutorial-java
heroku create myagentaction
git push heroku main
```

Once this has been deployed, refer to the instructions in [configuring Heroku-based actions in your Salesforce organization](https://github.com/heroku-examples/heroku-agentforce-tutorial/tree/heroku-integration-pilot).

Running and Testing Locally
---------------------------

Although you cannot integrate this app with Agentforce until you deploy it, you can still develop and test your action’s inputs and outputs locally, using the built-in [Swagger UI](https://swagger.io/tools/swagger-ui/). Once you are satisfied with your changes, refer to the deployment and configuration steps above.

```
git clone -b heroku-integration-pilot https://github.com/heroku-examples/heroku-agentforce-tutorial-java
cd heroku-agentforce-tutorial-java
mvn clean install
mvn spring-boot:run
```

Once the application is running, navigate to the URL below, and click the **Try it Out** button.

```
http://localhost:8080/swagger-ui/index.html
```
