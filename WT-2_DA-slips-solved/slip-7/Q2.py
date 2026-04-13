import pandas as pd
from mlxtend.frequent_patterns import apriori, association_rules
from mlxtend.preprocessing import TransactionEncoder

# Read the dataset, specifying data types
df = pd.read_csv("C:/xampp/htdocs/WT-2/WT-2_DA-slips-solved/CSV/market.csv", dtype={'Transaction_ID': str, 'Items': str})
print("Columns:", df.columns)
# Drop null values
df.dropna(inplace=True)

# Convert items to list of lists
transactions = df['Items'].str.split(',')

# Convert categorical values to numeric using TransactionEncoder
te = TransactionEncoder()
te_ary = te.fit(transactions).transform(transactions)
df = pd.DataFrame(te_ary, columns=te.columns_)

# Display information
print("Original Dataset:")
print(df.head())

# Generate frequent itemsets using Apriori algorithm with lower min_support
frequent_itemsets = apriori(df, min_support=0.001, use_colnames=True)

# Filter out itemsets with very low support before applying association rules
frequent_itemsets = frequent_itemsets[frequent_itemsets['support'] >= 0.01]

# Generate association rules from frequent itemsets with lower min_threshold
rules = association_rules(frequent_itemsets, metric='confidence', min_threshold=0.3)

# Display information
print("\nFrequent Itemsets:")
print(frequent_itemsets)

print("\nAssociation Rules:")
print(rules)
