package com.example.spel;

import com.example.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;

public class CollectionExprSample {

    public static void main(String[] args) {
        User user=new User();
        user.setId(1);
        user.setUsername("zhangsan");
        //构造SpEL解析上下文
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context=new StandardEvaluationContext(user);

        //数组解析表达式
        int[] array= (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);

        //List表达式解析
        List list= (List) parser.parseExpression("{1,2,3,4}").getValue(context);

        //列表字符串解析
        Map userInfo= (Map) parser.parseExpression("{username:'tom',id:10}").getValue(context);

        //从数组，List，Map中取值
        String str1= (String) parser.parseExpression("interestsArray[0]").getValue(context);
        String str2= (String) parser.parseExpression("interestsList[0]").getValue(context);
        String str3= (String) parser.parseExpression("interestsMap['str1']").getValue(context);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
