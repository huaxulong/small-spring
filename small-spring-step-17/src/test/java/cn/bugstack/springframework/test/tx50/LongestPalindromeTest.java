package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: longestPalindromeTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-08 5:49 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class LongestPalindromeTest {

    public String longestPalindrome(String s) {
        // 固定长度 + 滑动窗口
        // 先假设长度为 s.length(), i 表示长度
        for (int i = s.length(); i > 0 ; i--) {
            // 开始index
            for (int j = 0; j <= s.length() - i; j++) {
                if (isCycle(s.toCharArray(), j, j+i-1)){
                    return s.substring(j, j+i);
                }
            }
        }
        return "";
    }

    private boolean isCycle(char[] chars, int begin, int end) {
        int index = (begin + end) / 2;
        for (int i = begin; i <= index ; i++) {
            if (chars[begin] != chars[end]){
                return false;
            }
            begin ++;
            end --;
        }
        return true;
    }

    @Test
    public void test1() {
        String str1 = "dfegghyabccbadfsdfs";

        System.out.println(isCycle(str1.toCharArray(), 7, 12));

        System.out.println(str1.substring(0, str1.length()));
    }

    @Test
    public void test(){
        String str = "jhgtrclvzumufurdemsogfkpzcwgyepdwucnxrsubrxadnenhvjyglxnhowncsubvdtftccomjufwhjupcuuvelblcdnuchuppqpcujernplvmombpdttfjowcujvxknzbwmdedjydxvwykbbamfnsyzcozlixdgoliddoejurusnrcdbqkfdxsoxxzlhgyiprujvvwgqlzredkwahexewlnvqcwfyahjpeiucnhsdhnxtgizgpqphunlgikogmsffexaeftzhblpdxrxgsmeascmqngmwbotycbjmwrngemxpfakrwcdndanouyhnnrygvntrhcuxgvpgjafijlrewfhqrguwhdepwlxvrakyqgstoyruyzohlvvdhvqmzdsnbtlwctetwyrhhktkhhobsojiyuydknvtxmjewvssegrtmshxuvzcbrabntjqulxkjazrsgbpqnrsxqflvbvzywzetrmoydodrrhnhdzlajzvnkrcylkfmsdode";
        System.out.println(longestPalindrome(str));
    }

}
