class Solution {
    private String toBinary(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2 == 0 ? "0" : "1");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        return toBinary(year) + "-" + toBinary(month) + "-" + toBinary(day);
    }
}