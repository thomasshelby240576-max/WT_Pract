import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

# Load the csv data
df = pd.read_csv("D:/Computer Science/TY/SEM6/Slips/WT-2_DA-slips-solved/CSV/fish.csv")

# Define feature columns 
feature_cols = ['Length', 'Diagonal', 'Height', 'Width']
X = df[feature_cols]  

# Target variable 
y = df['Weight']   

# Split data into train and test sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42) 

# Create a LinearRegression and fit on training data
model = LinearRegression()
model.fit(X_train, y_train)   

# Evaluate model performance
print(f"R^2 Score on Train set: {model.score(X_train, y_train):.3f}")
print(f"R^2 Score on Test set: {model.score(X_test, y_test):.3f}")

# Visualization
plt.scatter(y_train, model.predict(X_train))
plt.xlabel("True Values")
plt.ylabel("Predictions") 

plt.show()
