<h1>Table of Contents</h1>

- [Model-View-ViewModel (MVVM)](#model-view-viewmodel-mvvm)
  - [What is Archtecture?](#what-is-archtecture)
  - [What is the Advantages?](#what-is-the-advantages)
  - [Introduction to MVVM](#introduction-to-mvvm)
    - [Model](#model)
    - [View](#view)
    - [ViewModel](#viewmodel)
  - [Why MVVM?](#why-mvvm)

# Model-View-ViewModel (MVVM)

## What is Archtecture?
When it comes to architecture in software development, actually we talk about the foundation of the software. To simplify its meaning, we can refer it to house architecture. Before building the house, architect should design the foundation, make sure that the foundation is strong enough to be lived. But, why we need the architecture while we can build the house without it? Well, let's take a look at this scenario. In the next year, you want to built the second floor above your house. Of course, you should have to make sure that your house is strong enough to hold all the things that placed in the second floor. Not all the house architecture is designed to hold the second floor, let alone no architecture.
Let's back to software architecture. The scenario above also happen in software, for example add some new features, fix some bugs, etc. Without architecture, it is still possible to make the changes in the software, but it is harder than if we used a suitable architecture.

## What is the Advantages?
- It is easier for your team to understand the code, because it is like a standardization of the software
- Easier to maintain the software
- Your code is reusable and scalable
- Can be easily tested

## Introduction to MVVM
MVVM is one of the most used architecture in android development aside from MVP, MVI, etc. MVVM consist of 3 main parts : **Model**, **View**, and **ViewModel**. Each part has its own responsibility, and it will be discussed here.

### Model
Model is one of the component in MVVM architecture that responsible for handling the data that is used in your app. it can be referred as the domain object, that represent the actual data.

### View
View responsible for any kind of interaction between the user and app. When the button is clicked, or user input an username in the app, View is responsible for handling that action. Activity, fragment are categorized as View in android. Please note that in this architecture, the view should not contain any business logic that used through your apps, including how the data fetched, where the source of your data, etc.

### ViewModel
ViewModel is the component that differ this architecture from others. ViewModel used as a bridge between the view and model. The data from model should be passed to ViewModel before it goes to certain view.
<br />
**Note : ViewModel should not have any reference to its view. It only provides the data, and the caller should subscribe to certain ViewModel. Because of this, ViewModel is survive from configuration changes**

## Why MVVM?
- Loose coupling between presentation and business logic (ViewModel is not have direct reference to View)
- Android lifecycle friendly (ViewModel survived when configuration changes)
- Well documented in Google docs
- Part of Jetpack component (_Jetpack is a suite of libraries, tools, guidance to help developers write high-quality apps more easily.
source : https://developer.android.com/jetpack/_)