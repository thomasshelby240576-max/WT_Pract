# Import necessary libraries
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split

# Create 'Position_Salaries' dataset
data = {'Position': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        'Level': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        'Salary': [45000, 50000, 60000, 80000, 110000, 150000, 200000, 300000, 500000, 1000000]}

df = pd.DataFrame(data)

# Identify independent (X) and target (y) variables
X = df[['Level']]
y = df['Salary']

# Split the variables into training and testing sets (7:3 ratio)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# Print the training and testing sets
print("Training set:")
print("X_train:\n", X_train)
print("y_train:\n", y_train)

print("\nTesting set:")
print("X_test:\n", X_test)
print("y_test:\n", y_test)

# Build a simple linear regression model
model = LinearRegression()
model.fit(X_train, y_train)

# Make predictions on the testing set
y_pred = model.predict(X_test)

# Evaluate the model
mse = mean_squared_error(y_test, y_pred)
print("\nMean Squared Error on Test Set:", mse)

# Plot the regression line
plt.scatter(X_test, y_test, color='blue', label='Actual')
plt.plot(X_test, y_pred, color='red', linewidth=2, label='Predicted')
plt.title('Simple Linear Regression Model')
plt.xlabel('Level')
plt.ylabel('Salary')
plt.legend()
plt.show()
