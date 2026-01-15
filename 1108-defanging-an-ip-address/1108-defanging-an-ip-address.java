class Solution {
    public String defangIPaddr(String address) {
        char old = ".";
        char newC = "[.]"; 
        return address.replace(old, newC);
    }
}
