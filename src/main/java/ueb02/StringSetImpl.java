package ueb02;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {

    Element root = null;

    class Element {
        String value;
        Element left, right;
        int size () {
            int s = 1;
            if (left != null) s += left.size();
            if (right != null) s += right.size();
            return s;
        }

        Element (String c, Element le, Element re) {
            value = c;
            left = le;
            right = re;
            }
            }




    public boolean add (String s) {

        Element e = new Element (s, null, null);

        if (root == null) {
            root = e;
        }

        Element it = root;
        while (it != null) {
            if (it.value.equals(e.value))
                return false;

            else if (e.value.compareTo(it.value) < 0) {
                if (it.left == null) {
                    it.left = e;
                    return true;
                } else
                    it = it.left;
            } else {
                if (it.right == null) {
                    it.right = e;
                    return true;
                } else
                    it = it.right;

            }


            }

        return false;
    }

    private void addElement (Element e) {
        if (e == null)
            return;

        if (root == null) {
            root = e;
            return;
        }

        Element it = root;
        while (it != null) {
            if (it.value.equals(e.value))
                return;
            else if (e.value.compareTo(it.value) < 0) {
                if (it.left == null) {
                    it.left = e;
                    return;
                } else
                    it = it.left;
            } else {
                if (it.right == null) {
                    it.right = e;
                    return;
                } else
                    it = it.right;
            }
        }
    }

    public boolean contains (String t) {
        if (root == null)
            return false;

        Element it = root;
        while (it != null) {
            if (t.equals(it.value)) {
                return true;
            }
            else if (t.compareTo(it.value) < 0) {
                it = it.left;
            } else {
                it = it.right;
            }
        }
        return false;
    }

    public String remove (String c) {

        if (root == null)
            throw new NoSuchElementException();

        if (root.value.equals(c)) {
            return removeRoot();
        }

        Element it = root;
        while (it != null) {
            if (c.compareTo(it.value) < 0) {
                if (it.left != null && it.left.value.equals(c))
                    return removeElement(it, it.left);
                it = it.left;
            } else {
                if (it.right != null && it.right.value.equals(c))
                    return removeElement(it, it.right);
                it = it.right;
            }
        }

        throw new NoSuchElementException();
    }

    private String removeRoot() {
        Element e = root;
        if (e.left == null && root.right == null) {
            root = null;
        } else if (e.left == null) {
            root = e.right;
        } else if (e.right == null) {
            root = e.left;
        } else {
            root = e.left;
            addElement(e.right);
        }

        return e.value;
    }

    private String removeElement(Element parent, Element element) {
        if (element == parent.left) {
            parent.left = null;
        } else {
            parent.right = null;
        }

        addElement(element.left);
        addElement(element.right);

        return parent.value;
    }





    public int size () {
        if (root == null) return 0;
        else return root.size();
    }


}
