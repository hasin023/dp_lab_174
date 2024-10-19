# Scenario

Consider we are building an application for a pizza store and we need a method to cook a pizza. There are three steps to cook a pizza in the pizza store:

- Prepare pizza dough;
- Add sauce and toppings;
- Bake the pizza.

The first step is a common behavior and the second and third steps are various for different pizza types. Now let’s assume we have a lot of new types of pizza in store, so we need many new pizza cookers(subclasses). However, some of the cookers have the same logic in step 2 and some of them have the same logic in step 3. We want these cookers can reuse the same logic through application to reduce code duplication.
