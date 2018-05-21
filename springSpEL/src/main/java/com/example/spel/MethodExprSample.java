package com.example.spel;

import com.example.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class MethodExprSample {

    public static void main(String[] args) {
        User user=new User();
        user.setId(1);
        user.setUsername("zhangsan");
        //构造SpEL解析上下文
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context=new StandardEvaluationContext(user);

        //调用String方法
        String substring=parser.parseExpression("'Spring SpEL'.substring(7)").getValue(String.class);
        //调用实例方法
        boolean isCorrect=parser.parseExpression("validatePassword('123456')").getValue(context,Boolean.class);
        //调用私有方法，将发生错误
         isCorrect=parser.parseExpression("validatePassword2('123456')").getValue(context,Boolean.class);
         //调用静态方法
         isCorrect=parser.parseExpression("validatePassword3('123456')").getValue(context,Boolean.class);

         //调用对象方法，可变参数列表
        parser.parseExpression("addInterests('Js','C')").getValue(context,Boolean.class);
    }
}
