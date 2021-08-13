package top.piao888.pool;

import java.util.concurrent.*;

/**
 * @author 许鸿志
 * @since 2021/8/13
 */
public class ThreadPool {
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(32, 64, 1, TimeUnit.HOURS, new LinkedBlockingQueue());

    public static void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    public static <T> T execute(Callable callable) throws ExecutionException, InterruptedException {
        FutureTask<T> futureTask = new FutureTask<>(callable);
        threadPoolExecutor.execute(futureTask);
        return futureTask.get();
    }
}
