from lorem_text import lorem
from random import randint

# print(lorem.paragraphs(5))

for i in range(100):
    f = open(f"./data/file-{i}", "w")
    f.write(lorem.paragraphs(randint(1,8000)))
    f.close()
