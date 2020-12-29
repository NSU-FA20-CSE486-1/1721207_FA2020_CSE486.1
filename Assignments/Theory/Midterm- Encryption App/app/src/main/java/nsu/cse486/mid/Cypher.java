package nsu.cse486.mid;

public class Cypher {

    public String encode(String strtxt, int codesrt) {
        StringBuilder itr_result = new StringBuilder();

        for (int i = 0; i < strtxt.length(); i++) {

            if (strtxt.charAt(i) >= 'A' && strtxt.charAt(i) <= 'Z') {
                char ch = (char)(((int)strtxt.charAt(i) + codesrt - 65) % 26 + 65);
                itr_result.append(ch);
            } else if(strtxt.charAt(i) >= 'a' && strtxt.charAt(i) <= 'z'){
                char ch = (char)(((int)strtxt.charAt(i) +
                        codesrt - 97) % 26 + 97);
                itr_result.append(ch);
            } else {
                itr_result.append(strtxt.charAt(i));
            }
        }

        return itr_result.toString();
    }

    public String decode(String message) {
        String[] tokens = message.split(" ", 2);

        int secret = tokens[0].hashCode() % 26;
        String cyphcode = tokens[1];

        return encode(cyphcode, 26-secret);
    }



}
