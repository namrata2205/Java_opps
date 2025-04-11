// 6. Multithreaded File Downloader (Simulation)
class FileDownloader extends Thread 
{
    private String fileName;

    public FileDownloader(String fileName) 
    {
        this.fileName = fileName;
    }

    public void run() 
    {
        System.out.println("Downloading " + fileName);
        try 
        {
            Thread.sleep((int)(Math.random() * 3000));
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Download interrupted for " + fileName);
        }
        System.out.println("Finished downloading " + fileName);
    }

    public static void main(String[] args) 
    {
        String[] files = {"file1.mp4", "file2.zip", "file3.pdf"};
        for (String file : files)
        {
            new FileDownloader(file).start();
        }
    }
}
