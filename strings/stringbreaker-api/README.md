# stringbreaker-api
API RESTful para formatação de texto. 

Ela transforma isso:
>In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the >deep, and the Spirit of God was hovering over the waters.
>
>And God said, "Let there be light," and there was light. God saw that the light was good, and he separated the light from the darkness. >God called the light "day," and the darkness he called "night." And there was evening, and there was morning - the first day.

num texto justificado com quantos caracteres por linha forem recebidos.

## Usando
Só utilizar os métodos abaixo usando o endpoint: https://stringbreaker-api.herokuapp.com
 
## Métodos
- **POST** - /formatted-text

    **body:**
    ```json
    {
      "text": "string",
      "lineLength: number
    }
    ```

    **response:**
    ```json
    {
      "message": "string",
      "text": "string"
    }
    ```
    
## Executando localmente
**Pré-requisitos:**
- Java 8

Executar o comando ```./mvnw spring-boot:run``` na raiz do projeto.
