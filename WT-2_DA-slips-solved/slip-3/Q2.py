import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import seaborn as sn
from sklearn import metrics
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split

# Load the dataset
dataset = pd.read_csv("D:/Computer Science/TY/SEM6/Slips/WT-2_DA-slips-solved/CSV/User_Data.csv")
# Select relevant features (Age and Estimated Salary) and the target variable (Purchased)
x = dataset.iloc[:, [2, 3]].values
y = dataset.iloc[:, 4].values
# Split the data into training and testing sets
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.25, random_state=0)
# Build a logistic regression model
logistic_regression = LogisticRegression()
logistic_regression.fit(x_train, y_train)
# Make predictions on the testing set
y_pred = logistic_regression.predict(x_test)
# Create a confusion matrix
confusion_matrix = pd.crosstab(y_test, y_pred, rownames=['Actual'], colnames=['Predicted'])
# Plot the confusion matrix using seaborn heatmap
sn.heatmap(confusion_matrix, annot=True)
# Print the accuracy score
print('Accuracy: ', metrics.accuracy_score(y_test, y_pred))
# Display the plot
plt.show()
# Print the testing set and predicted values
print(x_test)
print(y_pred)
