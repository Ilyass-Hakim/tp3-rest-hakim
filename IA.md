# Utilisation de l'IA pour le TP 3

**IA utilisée :** Claude (Anthropic)


## 1. Codes d'erreur avec Response

**Problème rencontré :**
La page d'introduction à JAX-RS demande un return qui renvoie une erreur « Internal Server Error », mais ne donne que `Response.ok(...)`.

**Raison de l'utilisation de l'IA :**
Trouver les méthodes de `Response` qui renvoient un code d'erreur HTTP.

**Prompt utilisé :**
« Quelles méthodes de `jakarta.ws.rs.core.Response` permettent de renvoyer un code d'erreur ? »

**Réponse de l'IA (extrait) :**
« `Response.serverError()` : erreur 500 (Internal Server Error). `Response.status(Response.Status.NOT_FOUND)` : n'importe quel code. [...] Avec un simple `String`, le code renvoyé est toujours 200. »

**Ce que j'ai appris :**

J'ai appris à utiliser la classe `Response` pour retourner différents codes d'erreur HTTP, notamment l'erreur 500 avec `serverError()`, et à comprendre la différence entre une réponse contenant uniquement une chaîne de caractères et une réponse HTTP personnalisée.

---

## 2. @SystemMessage ou mémoire

**Problème rencontré :**
L'énoncé propose 2 façons d'ajouter le rôle système (`@SystemMessage` ou la mémoire) sans dire laquelle choisir.

**Raison de l'utilisation de l'IA :**
Comprendre la différence entre les deux pour choisir celle qui convient à ce TP.

**Prompt utilisé :**
« Quelle est la différence entre mettre le rôle système avec `@SystemMessage` et l'ajouter dans la mémoire ? Dans quel cas choisir l'un ou l'autre ? »

**Réponse de l'IA (extrait) :**
« `@SystemMessage` : le rôle est écrit dans le code et fixe ; LangChain4j l'ajoute automatiquement à chaque requête. Dans la mémoire (`chatMemory.add(SystemMessage.from(...))`) : le rôle est une donnée ajoutée pendant l'exécution, qu'on peut changer en vidant la mémoire puis en ajoutant un autre rôle. »

**Ce que j'ai appris :**

J'ai appris la différence entre `@SystemMessage` et la mémoire dans LangChain4j. Le premier permet de définir un rôle système fixe, tandis que la mémoire permet de le modifier dynamiquement pendant l'exécution.

---

## 3. Paramètre de requête ?nb=4 (bonus)

**Problème rencontré :**
Pour le bonus, l'utilisateur doit pouvoir choisir le nombre d'endroits avec `?nb=4`. L'énoncé dit qu'« il faut savoir comment traiter les paramètres de requête » sans l'expliquer.

**Raison de l'utilisation de l'IA :**
Apprendre à lire un paramètre de requête avec une valeur par défaut, sur un exemple différent du TP.

**Prompt utilisé :**
« Comment lire un paramètre de requête `?nb=4` dans une méthode JAX-RS, avec une valeur par défaut ? Explique avec un exemple simple qui n'est pas mon TP. »

**Réponse de l'IA (extrait) :**
« On le récupère avec `@QueryParam`, et `@DefaultValue` donne sa valeur quand il est absent de l'URL. [...] Le paramètre de chemin est obligatoire, alors que le paramètre de requête est optionnel. »

**Ce que j'ai appris :**

J'ai appris à récupérer un paramètre de requête avec `@QueryParam` et à lui attribuer une valeur par défaut avec `@DefaultValue`. J'ai également compris la différence entre un paramètre de chemin et un paramètre de requête.

---

## 4. Variable dans @SystemMessage (bonus)

**Problème rencontré :**
Le rôle système demandait « les 2 principaux endroits ». Pour le bonus, ce nombre doit venir de l'URL, mais le texte de `@SystemMessage` est fixe.

**Raison de l'utilisation de l'IA :**
Savoir comment rendre une partie du rôle système variable avec LangChain4j.

**Prompt utilisé :**
« Comment passer une variable Java dans le texte d'un `@SystemMessage` avec LangChain4j ? »

**Réponse de l'IA (extrait) :**
« Le texte de `@SystemMessage` est un template, comme `PromptTemplate`. On y met une variable `{{nom}}` et on relie un paramètre de la méthode à cette variable avec `@V("nom")`. [...] `@UserMessage` est obligatoire dès que la méthode a plus d'un paramètre. »

**Ce que j'ai appris :**

J'ai appris à rendre les instructions du rôle système dynamiques avec LangChain4j en utilisant les variables `{{nom}}` et l'annotation `@V`. J'ai également compris que, lorsqu'une méthode a plusieurs paramètres, `@UserMessage` indique lequel contient la question de l'utilisateur.
