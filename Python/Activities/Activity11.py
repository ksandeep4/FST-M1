fruit_list = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}
 
fruit = input("which fruit you need? ").lower()
 
if(fruit in fruit_list):
    print("Yes, this is available")
else:
    print("No, this is not available")
    