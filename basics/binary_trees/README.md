# Binary Trees 
A binary tree is a tree where every node has two or fewer children. The children are usually called left and right.

```python
class BinaryTreeNode(object):

    def __init__(self, value):
        self.value = value
        self.left  = None
        self.right = None
```

## Classifying Binary Trees:
There are some particular names for classifying binary trees.
![Binary Tree](https://lh3.googleusercontent.com/proxy/1Zqci1UXnZRWKmOzxuzjEJcnuVILrmMdiERmm_mKaByD00XPyTslY6plmdZ4hujQ5RNKDQKIN1UVBmCRVCdRjV1whzuF20cHXHY-TZ4XTaEgHIzH00DBUN5vcA)

* If every level of the tree is completely full, we call this a 'perfect binary tree'

   * The number of total nodes on each level doubles as we move down the tree.
   * the number of nodes on the last level is equal to the sum of the number of nodes on all other levels (plus 1)
   * level n = 2^n nodes 
   * If we have the height of the binary tree 'h', the total number of nodes n = 2^0 + 2^1 + ..... 2^(h-1), or n = 2^h -1
   * height 'h' = log2(n+1)

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
