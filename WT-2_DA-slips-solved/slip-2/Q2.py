import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

# Create the Salary dataset
data = {'YearsExperience': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        'Salary': [50000, 60000, 70000, 80000, 90000, 100000, 110000, 120000, 130000, 140000]}

df = pd.DataFrame(data)

# Identify the independent and target variables
X = df.iloc[:, 0:1].values
y = df.iloc[:, 1].values

# Split the variables into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Build a simple linear regression model
model = LinearRegression()
model.fit(X_train, y_train)

# Make predictions on the testing set
y_pred = model.predict(X_test)

# Plot the regression line
plt.scatter(X_test, y_test, color='blue', label='Actual')
plt.plot(X_test, y_pred, color='red', linewidth=2, label='Predicted')
plt.title('Simple Linear Regression Model')
plt.xlabel('Years of Experience')
plt.ylabel('Salary')
plt.legend()
plt.show()
