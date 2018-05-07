package cn.com.introduceEnhancer;

public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicID){
        //开始对该方法进行性能监视
        //PerformanceMonitor.begin("removeTopic");
        System.out.println("模拟删除论坛topic记录:"+topicID);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //结束对该方法的性能监视
        //PerformanceMonitor.end();
    }

    public void removeForum(int topicID){
        //开始对该方法进行性能监视
       // PerformanceMonitor.begin("removeForum");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("模拟删除Forum记录："+topicID);
        //结束对该方法的性能监视
        //PerformanceMonitor.end();
    }
}
