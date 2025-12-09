Program ini adalah simulasi sederhana untuk mengelola penumpang Bus Trans Koetaradja menggunakan konsep OOP di Java. Di dalam proyek ini ada beberapa class, seperti Penumpang, PenumpangPrioritas, PenumpangBiasa, Bus, dan Main, serta satu custom exception bernama SaldoTidakCukupException.

Class Penumpang dibuat sebagai class abstrak yang menjadi dasar dari semua jenis penumpang. Dari sini, muncul dua jenis penumpang: prioritas dan biasa. Penumpang prioritas adalah mereka yang lanjut usia, anak kecil, atau ibu hamil. Masing-masing class turunan mengatur sendiri apakah mereka termasuk prioritas atau tidak. Semua penumpang juga punya saldo, dan setiap naik bus saldonya otomatis dipotong.

Class Bus bertugas mengatur seluruh penumpang. Bus punya tiga area: tempat duduk prioritas, tempat duduk biasa, dan area berdiri, masing-masing dengan kapasitas tertentu. Saat penumpang naik, bus akan mengecek saldo, memotong ongkos, lalu menempatkan penumpang ke area yang sesuai. Jika bus penuh atau saldo kurang, penumpang tidak bisa naik. Bus juga mencatat total pendapatan dan bisa menurunkan penumpang berdasarkan ID.

Class Main adalah menu utama yang dipakai pengguna. Dari sini pengguna bisa menambah penumpang, menurunkan penumpang, melihat isi bus, atau keluar dari program.
