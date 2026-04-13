import pandas as pd
from mlxtend.frequent_patterns import apriori, association_rules
from mlxtend.preprocessing import TransactionEncoder

transactions = {'No': [1, 2, 3, 4],
                'Company': ['Tata', 'MG', 'Kia', 'Hyundai'],
                'Model': ['Nexon', 'Astor', 'Seltos', 'Creta'],
                'Year': ['2017', '2021', '2019', '2015']}

print("Transactions: \n", transactions)

# Convert transactions to a list of lists
transaction_list = [[str(transactions[key][i]) for key in transactions.keys()] for i in range(len(transactions['No']))]

te = TransactionEncoder()
te_array = te.fit(transaction_list).transform(transaction_list)
df = pd.DataFrame(te_array, columns=te.columns_)
print("Data Set: \n", df)

freq_items = apriori(df, min_support=0.1, use_colnames=True)
print("Frequency Items: \n", freq_items)

rules = association_rules(freq_items, metric='support', min_threshold=0.5)
rules = rules.sort_values(['support', 'confidence'], ascending=[False, False])
print("Rules: \n", rules)
