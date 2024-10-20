class Solution {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : charArray) {
            if (c == ')' || c == '}' || c == ']') {
                if (list.isEmpty()) {
                    return false;
                } else {
                    if (c == ')' && list.getLast() == '(') {
                        list.removeLast();
                    } else if (c == '}' && list.getLast() == '{') {
                        list.removeLast();
                    } else if (c == ']' && list.getLast() == '[') {
                        list.removeLast();
                    } else {
                        return false;
                    }
                }
            } else {
                list.add(c);
            }
        }

        return list.isEmpty();
    }
}