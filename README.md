```
./gradlew bootRun
```

Puis http://127.0.0.1:8080/graphiql pour s'amuser.

1. Schéma de donnée (src/main/resources/graphql/schema.graphqls)
2. Model
3. GraphQLController @QueryMapping / @SchemaMapping

Requêtes:
1. Un livre (nom et nombre de page) par son identificateur (id: book-1)
2. Un livre et son auteur (prenom et nom)
3. Tous les livres du même auteur que le livre avec l'id book-1 
4. Les achats de l'utilisateur avec l'id: user-1
5. Des recommendations de livres des mêmes auteurs que les livres achetés par l'utilisateur avec l'id: user-1


