# BrewBuilder
CS2114 Project 2- Coffee Shop Order Builder

## How to Run

1. Open the BrewBuilder project in Eclipse.
2. Make sure the `main` source folder and `test` source folder are included in the project.
3. Open `BrewBuilderApp.java`.
4. Run `BrewBuilderApp` as a Java application.
5. Follow the console prompts to select a menu item and build an order.

## How to Run Tests

1. Open the `test` folder in Eclipse.
2. Open the test class that you want to run.
3. Run the class as a JUnit test.
4. The tests use `student.TestCase`.
5. Confirm that all implemented tests pass before submitting.

## Reflection



What changed from your specification?

Our original specification described the complete BrewBuilder MVP, including adding items, removing items, searching for items, updating items, clearing the order, customizing drinks, reviewing the order, and confirming a nonempty order.

For Deliverable 3, we focused first on creating a working prototype rather than completing every final feature at once. We created the main application classes from our specification, including `MenuItem`, `Drink`, `FoodItem`, `Menu`, `Order`, and `BrewBuilderApp`.

The largest implementation change involved the `Order` class. Our specification originally assumed that the LinkedChain might include position-based methods such as `remove(int index)` and `set(int index, T item)`. The LinkedChain provided for this deliverable does not include those methods. Because of this, position-based order operations must be implemented by the `Order` class while only using the public methods already provided by LinkedChain.

We also simplified the first console workflow so that we could create and test a functioning application slice before adding all of the final interactions and customization options.

- 
What changed in the LinkedChain?

We did not rewrite the provided `LinkedChain` storage structure.

The provided LinkedChain is used through its public API, including methods such as:

- `addToEnd`
- `remove`
- `get`
- `contains`
- `size`
- `isEmpty`
- `clear`
- `toString`

Application-specific behavior remains outside of LinkedChain. For example, LinkedChain does not decide whether an order may be confirmed or what constitutes a valid drink choice. Those decisions remain in the BrewBuilder application classes.

Our specification originally discussed possible position-based LinkedChain operations, but after receiving the provided class we adjusted the application to work with the actual public methods instead of adding application logic to LinkedChain.
- 
What happened to your unknowns

One uncertainty in our original specification was how we would preserve insertion order while allowing duplicate items. We resolved this by using `addToEnd` when adding order items. This allows multiple identical items to remain in the order while preserving the sequence in which the customer selected them.

Another uncertainty was where validation should occur. We are keeping validation separated by responsibility:

- `LinkedChain` handles structural storage rules.
- `Drink` handles drink-specific choices.
- `Order` handles order-specific rules.
- `BrewBuilderApp` handles user input and user-facing responses.

We also learned that the supplied LinkedChain does not contain all of the position-based methods that we originally considered. This required us to change the implementation of some `Order` methods without changing the storage class itself.

Remaining unknowns include the final form of the complete console interaction and how much of the stretch functionality we will include before the final submission.

- 
What doesn't work yet?
The prototype is still being completed.

The remaining work includes fully implementing and testing all public `Order` methods, completing invalid-input handling in the console application, finishing drink customization behavior, and making the application support a complete multi-step customer order rather than only the first working interaction.

Some test classes are also still being completed. Every public application method must have both a normal test case and a bad-input or boundary test case before the final submission.

The final application must also be tested as one complete workflow after the individual classes pass their unit tests.

- 

## Next Steps
What is left to finish the MVP?
The remaining MVP work will be completed in this order:

1. Finish the implementation of all `Order` methods.
2. Complete the tests for `Order`.
3. Confirm that `MenuItem`, `Drink`, `FoodItem`, and `Menu` behave correctly.
4. Complete the tests for those classes.
5. Finish the `BrewBuilderApp` console interaction.
6. Add invalid-input handling so incorrect choices do not crash the application.
7. Allow the customer to add more than one item to an order.
8. Support reviewing, removing, clearing, and confirming the order.
9. Run the full application workflow and correct any integration problems.
10. Run all tests and confirm that they pass.
- 
Which stretch goals will you attempt? 

After the MVP works correctly, we plan to attempt drink customization as our main stretch goal.

This includes allowing a customer to select a supported drink size and flavor rather than always using a default value.

If time permits, we may also improve the console workflow so the customer can continue editing an order until they choose to confirm it.

Payment processing, saved orders, dynamic pricing, and from-scratch recipes will remain outside the scope of this project.
- 
What new tests will you need?



- 
Who does what?
- 

## Attribution

| Class / Test File | Who? | How? |
| --- | --- | --- | 
| BrewBuilderApp | Oliver, Madison | Initialized, Wrote |
| Drink | Oliver, Sebastian | Wrote and Revised | 
| FoodItem | Oliver, Sebastian | Wrote and Revised |
| LinkedChain | Oliver  | Added | 
| Menu | Oliver, Sebastian | Initialized, Written | 
| MenuItem | Oliver, Sebastian | Wrote and Revised |
| Order | Oliver, Madison | Initialized, Wrote |
| TestBrewBuilderApp | Madison | Wrote |
| TestDrink | Sebastian | Drafted |
| TestFoodItem | Sebastian, Madison | Drafted, Revised |
| TestMenu | Sebastian | Drafted |
| TestMenuItem | Sebastian, Madison | Drafted, Revised |
| TestOrder | Oliver | Initialized |
| README | Everyone | Wrote | 
