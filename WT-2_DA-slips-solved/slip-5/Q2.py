import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import seaborn as sns
from sklearn import metrics
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split

df = pd.read_csv("D:\Computer Science\TY\SEM6\Data-Analytics\DA-pratical\CSV\iris.csv")

df['species'] = df['species'].map({'setosa': 0, 'versicolor': 1, 'virginica': 2})

for species in df['species'].unique():
    species_data = df[df['species'] == species]
    print(f"\nStatistics for Species {species}:\n{species_data.describe()}")

x = df[['sepal_length', 'sepal_width', 'petal_length', 'petal_width']]
y = df['species']

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.25, random_state=0)
logistic_regression = LogisticRegression()
logistic_regression.fit(x_train, y_train)
y_pred = logistic_regression.predict(x_test)

accuracy = metrics.accuracy_score(y_test, y_pred)
print(f"\nAccuracy: {accuracy}")
confusion_matrix = pd.crosstab(y_test, y_pred, rownames=['Actual'], colnames=['Predicted'])
sns.heatmap(confusion_matrix, annot=True, fmt='d')
plt.show()
