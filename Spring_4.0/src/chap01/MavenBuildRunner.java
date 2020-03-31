package chap01;

import java.util.List;

public class MavenBuildRunner implements BuildRunner
{
    private String mavenPath;
        
    public void build(List<String> srcDirs, String binDir)
    {
        String info = "메이븐 경로 : " + mavenPath + "\n";
        for(String srcDir  : srcDirs)
            info += "소스경로 : " + srcDir +"\n";
        info += "클래스파일 경로  : " + binDir +"\n";
        
        System.out.printf("MavenBuildRunner.build() 실행\n%s",info);
    }

    public void setMavenPath(String mavenPath)
    {
        this.mavenPath = mavenPath;
    }
    
}

interface BuildRunner
{
    public void build(List<String> srcDirs, String binDir);
}
