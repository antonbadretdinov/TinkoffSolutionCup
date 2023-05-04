# TinkoffSolutionCup Final

## Task

Develop a design system based on layouts from [Figma](https://www.figma.com/file/1NJhu9FkZwS5Km7WXtxkat/TinkoffSolutionCupFinal?node-id=0%3A1&t=h63EQX0QZD2TBLQM-1) in the form of a Gradle project.

Functional requirements:
- The library should come with a demo application that includes all components in all styles.
- No crashes and frame drops.
- Minimum SDK version: Android 7.0 (API level 24)

Technology requirements and limitations:
- Only Kotlin.
- You can only use View/ViewGroup.
- Dependencies on third-party libraries are prohibited during development.
- You can use third-party frameworks for testing.
===
## Preview of all elements
### Button
<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/button.png" width="200">

This custom button inherits from AppCompatButton, so it has all the same properties. For example:
```Kotlin
android:text="Button"
```
---
### Item
<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/items.png" width="200">

Change the title and description like this:
```Kotlin
app:title="Item title"
app:description="Any description"
```
Change the style to dark:
```Kotlin
app:isDarkStyle="true"
```
---
### Header
<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/headers.png" width="200">

Change the header and subheader like this:
```Kotlin
app:header="Header text"
app:subheader="Any subheader text"
```
Change the style to dark:
```Kotlin
app:isDarkStyle="true"
```
---
### Header with button
<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/buttonHeaders.png" width="200">

Change the header and subheader like this:
```Kotlin
app:header="Header text"
app:subheader="Any subheader text"
```
Change the style to dark:
```Kotlin
app:isDarkStyle="true"
```
Change button text:
```Kotlin
app:buttonText="Button"
```
---
### Vertical list
The vertical list is implemented through a recycler view. Each element of the list is represented by the item shown above. For each item, a model is used in which there are two fields: a title and a description.

<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/verticalLists.png" width="200">

Change the header like this:
```Kotlin
app:header="Header text"
```
Change the style to dark:
```Kotlin
app:isDarkStyle="true"
```
---
### Vertical list with button
<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/verticalButtonList1.png" width="200"> <img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/verticalButtonList2.png" width="200">

Change the header like this:
```Kotlin
app:header="Header text"
```
Change the style to dark:
```Kotlin
app:isDarkStyle="true"
```
Change button text:
```Kotlin
app:buttonText="Button"
```
---
### Horizontal list
The horizontal list is implemented through a recycler view. Each element of the list is represented by a special item for the horizontal list. For each item, a model is used in which there are two fields: a title and a description.

<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/horizontalList.png" width="200">

Change the header like this:
```Kotlin
app:header="Header text"
```
---
### Horizontal list with button
<img src="https://github.com/antonbadretdinov/TinkoffSolutionCup/blob/master/HorizontalButtonList.png" width="200">

Change the header like this:
```Kotlin
app:header="Header text"
```
Change button text:
```Kotlin
app:buttonText="Button"
```
