// 8. Job Scheduler using Threads
class JobScheduler {
    static class Job extends Thread {
        private final String jobName;
        private final int duration;

        public Job(String jobName, int duration) {
            this.jobName = jobName;
            this.duration = duration;
        }

        @Override
        public void run() {
            System.out.println(jobName + " started.");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted.");
            }
            System.out.println(jobName + " completed.");
        }
    }

    public static void main(String[] args) {
        Thread job1 = new Job("Job-1", 2000);
        Thread job2 = new Job("Job-2", 1000);
        Thread job3 = new Job("Job-3", 1500);

        job1.start();
        job2.start();
        job3.start();

        try {
            job1.join();
            job2.join();
            job3.join();
        } catch (InterruptedException e) {
            System.out.println("Job Scheduler interrupted.");
        }

        System.out.println("All jobs completed.");
    }
}
