# Spring 02: On the road

## Challenge
## Doctor who?

For this challenge you will create a single route using a controller:
- Create a Spring project, and make the application into a controller.
- Create a route that looks like this: /doctor/<incarnation number>.

For doctors 9 to 13 inclusive, return the details about the incarnation of the corresponding Doctor (here is a list). These details should be returned in JSON format, and include the doctor's number and name like this: {"number": 13, "name": "Jodie Whittaker"}. For the other doctors (1 to 8) return a 303 status. If the number is not valid, return a 404 status and display this informative message: ``Impossible to retrieve the incarnation <incarnation number>"` .

- Push your project into a GitHub repository and post the link to your repository as a solution.

## Validation criterias
- The controller contains a single route: /doctor/<incarnation number>.
- The route returns JSON data for the latest 5 incarnations, and a status 303 for the earlier ones, and for everything else it returns a status 404 with the agreed informative message.
- The code is available on github.
