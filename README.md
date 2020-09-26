# Simple linear regression with gradient descent in Java

Admittedly, I've bitten off a lot with my Java neuralnetwork package. Just to make sure I'm completely solid on gradient descent before diving into backprop, I wanted to make sure I could code the simplest version possible from scratch first.

## 9/25/20
Implemented stochastic gradient descent (SGD). Added Primes.java just for shuffling purposes, and GradientDescent.java, which actually creates and trains the model. Since I already knew the underlying model (y = 10 - 0.1x + U(-2, 2)), I didn't bother separating data into training and test sets, but I learned a lot!

What did I learn today? Stochastic gradient descent is just a BAD IDEA unless your learning rate is tiny and you have a large number of epochs. I found this out by generating linear data with a known pattern. After shuffling my points, I realized that unless my learning rate was below 0.0001, I would eventually get an exploding gradient.

This actually makes perfect sense (we get cascading error terms that keep increasing, then over-correct ad infinitum... literally, until Java gives up and declares the doubles "Infinity"), but I had never thought about it before. I'm glad I did this experiment!

Wonder what I'll learn about Batch and Mini-Batch when I get to those?