import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemItem {
    void print(String prefix, boolean isLast);
}

// Leaf
class FileItem implements FileSystemItem {
    private String name;

    public FileItem(String name) {
        this.name = name;
    }

    @Override
    public void print(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + "File: " + name);
    }
}

// Composite
class FolderItem implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    public FolderItem(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void print(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + "Folder: " + name);

        for (int i = 0; i < children.size(); i++) {
            FileSystemItem child = children.get(i);

            boolean childIsLast = i == children.size() - 1;

            String childPrefix;
            if (isLast) {
                childPrefix = prefix + "    ";
            } else {
                childPrefix = prefix + "│   ";
            }

            child.print(childPrefix, childIsLast);
        }
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        FolderItem root = new FolderItem("root");

        FolderItem level1 = new FolderItem("level1");
        FolderItem level2 = new FolderItem("level2");
        FolderItem level3 = new FolderItem("level3");
        FolderItem level4 = new FolderItem("level4");
        FolderItem level5 = new FolderItem("level5");

        level5.add(new FileItem("deep-file.txt"));
        level5.add(new FileItem("note.txt"));

        level4.add(level5);
        level4.add(new FileItem("level4-file.txt"));

        level3.add(level4);
        level3.add(new FileItem("level3-file.txt"));

        level2.add(level3);
        level2.add(new FileItem("level2-file.txt"));

        level1.add(level2);
        level1.add(new FileItem("level1-file.txt"));

        root.add(level1);
        root.add(new FileItem("root-file.txt"));

        root.print("", true);
    }
}
