package galerie.phototheque.repository;

import galerie.phototheque.entity.UserDownload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownloadRepository extends JpaRepository<UserDownload, Long> {
    List<UserDownload> findByImageId(Long imageId);
}
