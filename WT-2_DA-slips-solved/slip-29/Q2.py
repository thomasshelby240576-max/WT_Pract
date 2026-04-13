import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sn
from sklearn import metrics
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split

# Create a simple student score dataset
data = {'Hours_Studied': [2, 3, 4, 5, 6, 7, 8, 9, 10],
        'Pass': [0, 0, 0, 0, 1, 1, 1, 1, 1]}
df = pd.DataFrame(data)

# Separate features (X) and target variable (y)
X = df[['Hours_Studied']]
y = df['Pass']

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=0)

# Build a logistic regression model
logistic_regression = LogisticRegression()
logistic_regression.fit(X_train, y_train)

# Make predictions on the testing set
y_pred = logistic_regression.predict(X_test)

# Create a confusion matrix
confusion_matrix = pd.crosstab(y_test, y_pred, rownames=['Actual'], colnames=['Predicted'])

# Plot the confusion matrix using seaborn heatmap
sn.heatmap(confusion_matrix, annot=True, fmt='g')
plt.title('Confusion Matrix')
plt.show()

# Print the accuracy score
accuracy = metrics.accuracy_score(y_test, y_pred)
print(f'Accuracy: {accuracy}')
print('Testing Set:\n',X_test)
print('Predicted Values:\n',y_pred)
