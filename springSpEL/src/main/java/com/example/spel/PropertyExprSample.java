package com.example.spel;

import com.example.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class PropertyExprSample {

    public static void main(String[] args) {
        //构造一个对象
        User user=new User();
        user.setId(1);
        user.setUsername("zhangsan");
        //构造SpEL解析上下文
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context=new StandardEvaluationContext(user);

        //基本属性值获取
        String userName= (String) parser.parseExpression("username").getValue(context);
        int id= (int) parser.parseExpression("id+10").getValue(context);
        //嵌套对象属性值获取
        //String username= (String) parser.parseExpression("username").getValue(context);

        System.out.println(id+":"+userName);
    }
}
