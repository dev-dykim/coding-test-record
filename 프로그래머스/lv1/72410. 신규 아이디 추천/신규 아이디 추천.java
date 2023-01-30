class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase()
                    .replaceAll("[^a-z0-9\\-_.]", "")
                    .replaceAll("[.]{2,}", ".")
                    .replaceAll("^[\\.]", "")
                    .replaceAll("[\\.]$", "");

        System.out.println(new_id);

        if (new_id.length() == 0)
            new_id = "a";

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[\\.]$", "");
        }

        if (new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += last;
            }
        }

        return new_id;
    }
}
