package com.neto.desafio.batch;

import com.neto.desafio.domain.report.Report;
import org.springframework.batch.item.ItemWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static com.neto.desafio.batch.FilteItemReader.PATH_OF_CURRENT_FILE;
import static com.neto.desafio.shared.Constant.*;

public class FileItemWriter implements ItemWriter<Report> {


    @Override
    public void write(List<? extends Report> reports) throws Exception {
        for (Report report: reports) {
            saveReportToOutPutFile(report);
            moveProcessedFileToNewPath(PATH_OF_CURRENT_FILE);
        }
    }

    private void moveProcessedFileToNewPath(Path pathOfCurrentFile) throws IOException {
        Path processedPath = Paths.get(PATH_PROCESSED);
        Files.move(pathOfCurrentFile,processedPath.resolve(pathOfCurrentFile.getFileName()), StandardCopyOption.REPLACE_EXISTING);
    }

    private void saveReportToOutPutFile(Report report) throws IOException {
        Path outPath = Paths.get(PATH_OUT);
        // TODO fazer um FILEUTIL
        String fileName = PATH_OF_CURRENT_FILE.getFileName().toString();
        fileName = fileName.replace(" ", "_");
        fileName = fileName.substring(0, fileName.length()-4) + OUT_FILE_EXTENSION;

        Files.write(outPath.resolve(fileName), report.toString().getBytes());
    }
}
