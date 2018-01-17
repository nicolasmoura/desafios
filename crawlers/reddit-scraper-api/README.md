# reddit-scraper-api
Usando web scraping para descobrir quais threads estão bombando nos seus subreddits favoritos.  
O serviço está disponível em https://rddt-scraper-api.herokuapp.com
## Usando

É só enviar uma requisição ```GET``` para o endpoint ```/threads/hot```, enviando no parâmetro ```subreddits``` uma lista de subreddits separada por ponto-e-vírgula (;). Simples assim.

Exemplo: ```https://rddt-scraper-api.herokuapp.com/threads/hot?subreddits=wtf;music;worldnews```
 
## Métodos
- **GET** - /threads/hot

    **query parameters:**
    - ```subreddits```: *Lista de subreddits separada por ponto-e-vírgula* 

    **response:**
    ```json
    [
      {  
        "title":"What is the scariest, most terrifying thing that actually exists?",
        "upvotes":39785,
        "permalink":"https://www.reddit.com/r/AskReddit/comments/7qv45t/what_is_the_scariest_most_terrifying_thing_that/",
        "link":"https://www.reddit.com/r/AskReddit/comments/7qv45t/what_is_the_scariest_most_terrifying_thing_that/",
        "subreddit":"askreddit"
      },
    ]
    ```
    
    ```title```: título da thread  
    ```upvotes```: número de upvotes  
    ```permalink```: link para os comentários da thread  
    ```link```: link da thread  
    ```subreddit```: subreddit onde a thread foi postada  
    
## Executando localmente
**Pré-requisitos:**
- Java 8

Executar o comando ```./mvnw spring-boot:run -Dspring.active.profiles=dev``` na raiz do projeto.  
O serviço irá rodar em ```localhost:8080```
