class Solution {
    public String multiply(String num1, String num2) {
        // handling zero
        if(num1.equals("0") || num2.equals("0"))return "0";


        List<String> addList = new ArrayList<>();

        int n = num1.length();
        int m = num2.length();

        // first traverse num2 and make the add list
        for(int i=m-1;i>=0;i--){
            StringBuilder sb = new StringBuilder();
            for(int k=m-1;k>i;k--){
                sb.append('0');
            }
            int carry = 0;
            for(int j=n-1;j>=0;j--){
                int first = num2.charAt(i) - '0';
                int second = num1.charAt(j) - '0';
                int sum = first*second+carry;
                carry=0;
                if(sum>9){
                    carry = sum/10;
                    sum%=10;
                }
                sb.append((char)(sum + '0'));
            }
            if(carry>0)sb.append((char)(carry+'0'));
            addList.add(sb.toString());
        }

        // printing the list of addition
        for(int i=0;i<addList.size();i++){
            System.out.println(addList.get(i));
        }


        // then traverse the list and make the final sum
        StringBuilder finalAns = new StringBuilder();
        int first = addList.get(addList.size()-1).length();
        int carry = 0;
        for(int j=0;j<first;j++){
            int temp = 0;
            for(int i=0;i<addList.size();i++){
                if(j<addList.get(i).length()){
                    temp += addList.get(i).charAt(j) - '0';        
                }
            }
            temp += carry;
            carry=0;
            if(temp>9){
                carry = temp/10;
                temp %=10;
            }
            finalAns.append((char)(temp + '0'));
        }
        if(carry>0)finalAns.append((char)(carry + '0'));
        return finalAns.reverse().toString();

    }
}
